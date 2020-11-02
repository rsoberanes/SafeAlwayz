package com.studios.primitive.safealwayz.ui.main.SmartFridge;

import java.io.Serializable;

public class SmartFridge implements Serializable {

        //variables
        private int id;
        private int accountId;
        private String cameraName;

        //Constructor
        public SmartFridge(int accountId, String cameraName) {
            this.accountId = accountId;
            this.cameraName = cameraName;
            this.id = id;
        }

        public SmartFridge(){

        }

        //toString
        @Override
        public String toString() {
            return "AccountModel{" +
                    "accountId='" + accountId + '\'' +
                    "userName='" + cameraName + '\'' +
                    '}';
        }


        //Getter and Setters

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public String getCameraName() {
            return cameraName;
        }

        public void setCameraName(String userName) {
            this.cameraName = userName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
}
