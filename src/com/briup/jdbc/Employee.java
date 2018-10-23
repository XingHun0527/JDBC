package com.briup.jdbc;

import java.sql.Date;

public class Employee {
	
		int id;
		String  lastName;
		double salary;
	
		public Employee(String lastName, int id, double salary) {
			this.lastName=lastName;
			this.id=id;
			this.salary=salary;
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Employee [ id=" + id + ", lastName=" + lastName + ", salary=" + salary + "]";
		}

		
}
