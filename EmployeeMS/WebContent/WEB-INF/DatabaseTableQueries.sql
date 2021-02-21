create table Department
(
	depId char(7),
	Name varchar(20) NOT NULL unique,
	Location varchar(40) NOT NULL,

	constraint Pk_Dep primary key(depId)
) ;

create table Employee
(
	EmpId char(7),
	fullname varchar(30) NOT NULL UNIQUE,
    JobTitle varchar(30),
	address varchar(40) NOT NULL,
	Gender varchar(6) NOT NULL,
    DOB date,
    MaritalStatus varchar(20),
	NIC char(10),
	phone_no char(10),
	Date_of_joint date ,
	salary real ,
	department varchar(20),

	constraint Pk_Emp primary key(EmpId),
	constraint fk_dep foreign key(department) references Department(Name) ON UPDATE CASCADE
    ON DELETE CASCADE,
	CONSTRAINT chk_sal CHECK (salary > 0)
);

create table Login
(
	LoginId int ,    
	EmpLoyee char(7) NOT NULL,
	Username varchar(30) NOT NULL unique,  
	pwd varchar(15) NOT NULL unique,
	Role varchar(30) NOT NULL, 

	constraint Pk_Login primary key(LoginId),
	constraint fk_Emp foreign key(Employee) references Employee(EmpId) ON UPDATE CASCADE
    ON DELETE CASCADE,
	
	CONSTRAINT chk_role CHECK (Role IN('HR','Manager','Employee'))
) ;

create table Manager
(
	ManagerId char(7) ,
	Employee varchar(30),
    department varchar(20) ,
	Starting_Date date ,
	LoginId int ,

	constraint Pk_Manager primary key(ManagerId),
	constraint fk_Login foreign key(LoginId) references Login(LoginId),
	constraint fk_Memp foreign key(Employee) references Employee(fullname) ON UPDATE CASCADE
    ON DELETE CASCADE,
	constraint fk_Mdep foreign key(department) references Department(Name)  ON UPDATE CASCADE
    ON DELETE CASCADE
);

create table E_Leave
(
	LeaveId char(7),
	Employee varchar(30),
	department varchar(20),
	Starting_Date date,
	End_Date date,
	L_Status varchar(20),
	description Varchar(50),

	constraint Pk_Leave primary key(LeaveId),
	constraint fk_leave_Emp foreign key(Employee) references Employee(fullname) ON UPDATE CASCADE
    ON DELETE CASCADE,
	constraint fk_leave_dep foreign key(department) references Department(Name) ON UPDATE CASCADE
    ON DELETE CASCADE,
	CONSTRAINT chk_LStatus CHECK (L_Status IN('Pending','Approve','Reject'))
) ;

create table Tasks
(
	TaskId char(7),
	Employee varchar(30),
	department varchar(20),
	TaskName varchar(210) NOT NULL,
	AssignDate date NOT NULL,

	constraint Pk_Task primary key(TaskId),
	constraint fk_Task_Emp foreign key(Employee) references Employee(fullname) ON UPDATE CASCADE
    ON DELETE CASCADE,
	constraint fk_Task_dep foreign key(department) references Department(Name) ON UPDATE CASCADE
    ON DELETE CASCADE
) ;

create table Attendance
(
	AttId char(7),
	Employee varchar(30),
	department varchar(20),
    T_Date date,
	Start_Time TIME,
	End_Time TIME,
	A_Status char(20),

	constraint Pk_Attendace primary key(AttId),
	constraint fk_Attendace_Emp foreign key(Employee) references Employee(fullname) ON UPDATE CASCADE
    ON DELETE CASCADE,
	constraint fk_Attendace_dep foreign key(department) references Department(Name) ON UPDATE CASCADE
    ON DELETE CASCADE,
	CONSTRAINT chk_AttendStatus CHECK (A_Status IN('Present','Leave','Absent'))
) ;

create table AttendanceStatus
(
	AttStId char(7),
	AttId char(7),
	Employee varchar(30),
    Department varchar(20),
	NoWorkingDays integer NOT NULL,
	NoLeaveDays integer NOT NULL,

	constraint Pk_AttendaceSt primary key(AttId,AttStId),
	constraint fk_Attendace_T foreign key(AttId) references Attendance(AttId)ON UPDATE CASCADE
    ON DELETE CASCADE,
	constraint fk_Emp_AS foreign key(Employee) references Employee(fullname) ON UPDATE CASCADE
    ON DELETE CASCADE,
    constraint fk_AttendaceStatus_dep foreign key(department) references Department(Name) ON UPDATE CASCADE
    ON DELETE CASCADE
) ;
