package ir.sample.parcelablesample.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class UserEntity implements Parcelable {
    int id ;
    String username;
    String emailAddress;
    String phoneNumber;
    String jobTitle;

    public UserEntity() {
    }

    public UserEntity(int id, String username, String emailAddress, String phoneNumber, String jobTitle) {
        this.id = id;
        this.username = username;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.username);
        dest.writeString(this.emailAddress);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.jobTitle);
    }

    protected UserEntity(Parcel in) {
        this.id = in.readInt();
        this.username = in.readString();
        this.emailAddress = in.readString();
        this.phoneNumber = in.readString();
        this.jobTitle = in.readString();
    }

    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
