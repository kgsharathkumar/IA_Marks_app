package com.example.ise;

public class RegisterData {


        //private variables
        int _id;
        String user_name;
        String password;

        // Empty constructor
        public RegisterData() {

        }

        // constructor
        public RegisterData(int id, String user_name, String password) {
                this._id = id;
                this.user_name = user_name;
                this.password = password;

        }


        // getting ID
        public int getID() {
                return this._id;
        }

        // setting id
        public void setID(int id) {
                this._id = id;
        }

        public String getUser_name() {
                // TODO Auto-generated method stub
                return user_name;
        }

        // setting  first name
        public void setUser_name(String user_name) {
                this.user_name = user_name;
        }

        public String getPassword() {
                // TODO Auto-generated method stub
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}