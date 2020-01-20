package com.example.loginapplication;


import android.os.Parcel;
import android.os.Parcelable;

public class FakeServer implements Parcelable {
    private String name;
    private String password;

    public FakeServer() {
    }

    protected FakeServer(Parcel in) {
        name = in.readString();
        password = in.readString();
    }

    public String getName() {
        return name;
    }

    public static final Creator<FakeServer> CREATOR = new Creator<FakeServer>() {
        @Override
        public FakeServer createFromParcel(Parcel in) {
            return new FakeServer(in);
        }

        @Override
        public FakeServer[] newArray(int size) {
            return new FakeServer[size];
        }
    };

    public void registerUser(String name, String userPass) {
        this.name = name;
        this.password = userPass;
    }

    public boolean isExistingUser(String username, String userPassword) {

        return username.equals(name) && password.equals(userPassword);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
    }
}
