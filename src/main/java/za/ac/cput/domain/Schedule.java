/* Schedule.java  
Schedule model class 
Author Angelo Adams (230450431) 
Date: 04 March 2026 */
package za.ac.cput.domain;

public class Schedule {

    private String scheduleId;
    private String instructorId;
    private String vehicleId;
    private String status;

//default contructor
    public Schedule(){
        
    }
        //constructor arg
    private Schedule(Builder builder) {
        this.scheduleId = builder.scheduleId;
        this.instructorId = builder.instructorId;
        this.vehicleId = builder.vehicleId;
        this.status = builder.status;
    }


    public String getScheduleId() { return scheduleId; }
    public String getInstructorId() { return instructorId; }
    public String getVehicleId() { return vehicleId; }
    public String getStatus() { return status; }

    // Builder patterns
    public static class Builder {
        private String scheduleId;
        private String instructorId;
        private String vehicleId;
        private String status;

        //setters
        public Builder setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
            return this;
        }

        public Builder setInstructorId(String instructorId) {
            this.instructorId = instructorId;
            return this;
        }

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Schedule schedule) {
            this.scheduleId = schedule.scheduleId;
            this.instructorId = schedule.instructorId;
            this.vehicleId = schedule.vehicleId;
            this.status = schedule.status;
            return this;
        }

        public Schedule build() {
            return new Schedule(this);
        }
    }
}
