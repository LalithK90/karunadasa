package lk.learners.karunadasa.resoursesCompany.human.controller;

import lk.learners.karunadasa.general.security.service.UserService;
import lk.learners.karunadasa.resoursesCompany.human.entity.Enum.Gender;
import lk.learners.karunadasa.resoursesCompany.human.entity.Enum.Title;
import lk.learners.karunadasa.resoursesCompany.human.entity.Student;
import lk.learners.karunadasa.resoursesCompany.human.service.StudentService;
import lk.learners.karunadasa.util.service.DateTimeAgeService;
import lk.learners.karunadasa.util.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final DateTimeAgeService dateTimeAgeService;
    private final UserService userService;
    private final EmailService emailService;

    @Autowired
    public StudentController(StudentService studentService, DateTimeAgeService dateTimeAgeService, UserService userService, EmailService emailService) {
        this.studentService = studentService;
        this.dateTimeAgeService = dateTimeAgeService;
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping
    public String patientPage(Model model) {
        java.util.List<Student> patients = studentService.findAll();
        model.addAttribute("patients", patients);
        return "student/student";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String patientView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("patientDetail", studentService.findById(id));
        return "student/student-detail";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPatientFrom(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("newPatient", studentService.findById(id).getNumber());
        model.addAttribute("addStatus", Boolean.valueOf(false));
        model.addAttribute("title", Title.values());
        model.addAttribute("gender", Gender.values());
        return "student/addPatient";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String patientAddFrom(Model model) {
        String newStudentNumber = "";
        String input;
        if (studentService.lastStudent() != null) {
             input = studentService.lastStudent().getNumber();
            int employeeNumber = Integer.valueOf(input.replaceAll("[^0-9]+", "")).intValue() + 1;

            if ((employeeNumber < 10) && (employeeNumber > 0)) {
                newStudentNumber = "KLS000" + employeeNumber;
            }
            if ((employeeNumber < 100) && (employeeNumber > 10)) {
                newStudentNumber = "KLS00" + employeeNumber;
            }
            if ((employeeNumber < 1000) && (employeeNumber > 100)) {
                newStudentNumber = "KLS0" + employeeNumber;
            }
            if (employeeNumber > 10000) {
                newStudentNumber = "KLS" + employeeNumber;
            }
        } else {
            newStudentNumber = "KLS0001";
            input = "KLS0000";
        }
        model.addAttribute("addStatus", true);
        model.addAttribute("lastPatient", input);
        model.addAttribute("newPatient", newStudentNumber);
        model.addAttribute("title", Title.values());
        model.addAttribute("gender", Gender.values());
        model.addAttribute("student", new Student());
        return "student/addPatient";
    }


    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public String addPatient(@Valid @ModelAttribute Student student, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + ": " + error.getDefaultMessage());
            }
            model.addAttribute("addStatus", true);
            model.addAttribute("title", Title.values());
            model.addAttribute("gender", Gender.values());
            model.addAttribute("student", student);
            return "/student/addPatient";
        }
        if (student.getId() != null) {
            student.setUpdatedAt(dateTimeAgeService.getCurrentDate());
            if (student.getEmail() != null) {


                String message = "Welcome to Excellent Health Solution \n Your detail is updated\t\t\tAFTER UPDATE YOUR DETAILS\nYour Details are\n " + student.getTitle().getTitle() + " " + student.getName() + "\n " + student.getNic() + "\n " + student.getDateOfBirth() + "\n " + student.getMobile() + "\n " + student.getLand() + "\n " + student.getBloodGroup().getBloodGroup() + "\n " + student.getAddress() + "\n\n\n\n\n Please inform us to if there is any changes on your details\n Kindly request keep your data up to date with us. so we can provide better serviceStation for you.\n \n \n   Thank You\n Excellent Health Solution";


                boolean isFlag = emailService.sendPatientRegistrationEmail(student.getEmail(), "Welcome to Excellent Health Solution ", message);
                if (isFlag) {
                    redirectAttributes.addFlashAttribute("message", "Successfully Update and Email was sent.");
                    redirectAttributes.addFlashAttribute("alertStatus", true);
                    studentService.persist(student);
                    return "redirect:/student";
                }
                redirectAttributes.addFlashAttribute("message", "Successfully Update but Email was not sent.");
                redirectAttributes.addFlashAttribute("alertStatus",false);
                studentService.persist(student);
                return "redirect:/student";
            }


            studentService.persist(student);
            return "redirect:/student";
        }
        if (student.getEmail() != null) {


            String message = "Welcome to Excellent Health Solution \n Your registration number is " + student.getNumber() + "\nYour Details are\n " + student.getTitle().getTitle() + " " + student.getName() + "\n " + student.getNic() + "\n " + student.getDateOfBirth() + "\n " + student.getMobile() + "\n " + student.getLand() + "\n " + student.getBloodGroup().getBloodGroup() + "\n " + student.getAddress() + "\n\n\n\n\n Please inform us to if there is any changes on your details\n Kindly request keep your data up to date with us. so we can provide better serviceStation for you.\n \n \n   Thank You\n Excellent Health Solution";


            boolean isFlag = emailService.sendPatientRegistrationEmail(student.getEmail(), "Welcome to Excellent Health Solution ", message);
            if (isFlag) {
                redirectAttributes.addFlashAttribute("message", "Successfully Add and Email was sent.");
                redirectAttributes.addFlashAttribute("alertStatus", true);
                student.setCreatedAt(dateTimeAgeService.getCurrentDate());
                studentService.persist(student);
                return "redirect:/student";
            }
            redirectAttributes.addFlashAttribute("message", "Successfully Add but Email was not sent.");
            redirectAttributes.addFlashAttribute("alertStatus", false);
            student.setCreatedAt(dateTimeAgeService.getCurrentDate());
            studentService.persist(student);
            return "redirect:/student";
        }

        student.setCreatedAt(dateTimeAgeService.getCurrentDate());
        student.setCreatedUser(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        studentService.persist(student);
        return "redirect:/student";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removePatient(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/student";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, Student student) {
        model.addAttribute("patientDetail", studentService.search(student));
        return "student/student-detail";
    }
}