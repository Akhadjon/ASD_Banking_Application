package project.framwork.model;

import project.framwork.Address;
import project.framwork.util.Observer;

public interface Customer extends Observer {
    String getFullName();
    String  getAge();
    String getEmail();
    Address getAddress();
    String getID();
    void setAccount(Account account);
}
