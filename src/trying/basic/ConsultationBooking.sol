// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ConsultationBooking {
    address public doctor;
    address public patient;
    uint256 public consultationFee;
    bool public consultationStarted;
    bool public consultationCompleted;
    
    
    

    event ConsultationBooked(address indexed patient, uint256 fee);
    event ConsultationStarted(address indexed doctor, address indexed patient);
    event ConsultationCompleted(address indexed doctor, address indexed patient);

    modifier onlyDoctor() {
        require(msg.sender == doctor, "Only the doctor can call this function");
        _;
    }  

        

    modifier onlyPatient() {
        require(msg.sender == patient, "Only the patient can call this function");
        _;
    }

    modifier consultationNotStarted() {
        require(!consultationStarted, "Consultation has already started");
        _;
    }

    modifier consultationNotCompleted() {
        require(!consultationCompleted, "Consultation has already been completed");
        _;
    }


    constructor (address _patient, address _doctor, uint256 _consultationFee) payable {
        require(msg.value > 0, "Value cannot equal zero");
        require(_patient != address(0), "Invalid patient address");
        require(_doctor != address(0), "Invalid doctor address");
        require(_consultationFee > 0, "Consultation fee must be greater than 0");

        doctor = _doctor;
        patient = _patient;

        consultationFee = _consultationFee;
    }

   function bookConsultaion() external payable onlyPatient consultationNotStarted {
    require(msg.sender.balance >= consultationFee * 1 wei , "Incorrect consultation fee");

    consultationStarted = true;

    emit ConsultationBooked(patient, consultationFee);
}


    function startConsultation() external onlyDoctor consultationNotCompleted {
        require(consultationStarted, "Consultation has not been booked yet");

        emit ConsultationStarted(doctor, patient);
    }

    function completeConsultation() external onlyDoctor consultationNotCompleted {
        require(consultationStarted, "Consultation has not been booked yet");

        // Transfer the consultation fee to the doctor
        (bool success, ) = doctor.call{value: consultationFee}("");
        require(success, "Failed to transfer consultation fee to the doctor");

        consultationCompleted = true;

        emit ConsultationCompleted(doctor, patient);
    }

    
   

    // Fallback function to reject direct payments to the contract
    receive() external payable {
        revert("Use the bookConsultation function to initiate the consultation");
    }
}
