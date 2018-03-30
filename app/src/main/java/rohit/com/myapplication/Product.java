package rohit.com.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

//    private int id;

    private String UserId;
    private String FullName;
    private String ProfileIcon;
    private String Email;
    private String Mobile;
    private String RoleID;
    private String RoleName;
    private String Status;
    private String ManagerName;

    @Override
    public String toString() {
        return "Product{" +
                "UserId='" + UserId + '\'' +
                ", FullName='" + FullName + '\'' +
                ", ProfileIcon='" + ProfileIcon + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", RoleID='" + RoleID + '\'' +
                ", RoleName='" + RoleName + '\'' +
                ", Status='" + Status + '\'' +
                ", ManagerName='" + ManagerName + '\'' +
                '}';
    }


//    public Product(String userId, String fullName, String profileIcon, String email, String mobile, String roleID, String roleName, String status, String managerName) {
//        this.UserId = userId;
//        this.FullName = fullName;
//        this.ProfileIcon = profileIcon;
//        this.Email = email;
//        this.Mobile = mobile;
//        this.RoleID = roleID;
//        this.RoleName = roleName;
//        this.Status = status;
//        this.ManagerName = managerName;
//    }






//            "UserId"
//            "FullName"
//            "ProfileIcon"
//            "Email"
//            "Mobile"
//            "RoleID"
//            "RoleName"
//            "Status"
//            "ManagerName"


    public String getUserId() {
        return UserId;
    }

    public String getFullName() {
        return FullName;
    }

    public String getProfileIcon() {
        return ProfileIcon;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getRoleID() {
        return RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public String getStatus() {
        return Status;
    }

    public String getManagerName() {
        return ManagerName;
    }


//    public void setUserId(String userId) {
//        UserId = userId;
//    }
//
//    public void setFullName(String fullName) {
//        FullName = fullName;
//    }
//
//    public void setProfileIcon(String profileIcon) {
//        ProfileIcon = profileIcon;
//    }
//
//    public void setEmail(String email) { Email = email;
//    }
//
//    public void setMobile(String mobile) {
//        Mobile = mobile;
//    }
//
//    public void setRoleID(String roleID) {
//        RoleID = roleID;
//    }
//
//    public void setRoleName(String roleName) {
//        RoleName = roleName;
//    }
//
//    public void setStatus(String status) {
//        Status = status;
//    }
//
//    public void setManagerName(String managerName) {
//        ManagerName = managerName;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.UserId);
        dest.writeString(this.FullName);
        dest.writeString(this.ProfileIcon);
        dest.writeString(this.Email);
        dest.writeString(this.Mobile);
        dest.writeString(this.RoleID);
        dest.writeString(this.RoleName);
        dest.writeString(this.Status);
        dest.writeString(this.ManagerName);
    }

    protected Product(Parcel in) {
        this.UserId = in.readString();
        this.FullName = in.readString();
        this.ProfileIcon = in.readString();
        this.Email = in.readString();
        this.Mobile = in.readString();
        this.RoleID = in.readString();
        this.RoleName = in.readString();
        this.Status = in.readString();
        this.ManagerName = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}

