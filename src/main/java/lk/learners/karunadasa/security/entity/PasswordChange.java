package lk.learners.karunadasa.security.entity;

import javax.validation.constraints.Size;


public class PasswordChange {
    private String username;
    @Size(min=4, message="password should include four characters or symbols")
    private String opsw;

    public void setUsername(String username) { this.username = username; } public void setOpsw(String opsw) { this.opsw = opsw; } public void setNpsw(String npsw) { this.npsw = npsw; } public void setNrepsw(String nrepsw) { this.nrepsw = nrepsw; }
    public PasswordChange(String username, String opsw, String npsw, String nrepsw) { this.username = username;this.opsw = opsw;this.npsw = npsw;this.nrepsw = nrepsw;
    }

    public String getUsername() { return username; }

    public String getOpsw() { return opsw; } public String getNpsw() { return npsw; } public String getNrepsw() { return nrepsw; }

    @Size(min=4, message="password should include four characters or symbols")
    private String npsw;
    @Size(min=4, message="password should include four characters or symbols")
    private String nrepsw;
    public PasswordChange() {}
}