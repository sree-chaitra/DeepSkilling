// src/EmployeesList.js
import React from 'react';
import EmployeeCard from './EmployeeCard';

function EmployeesList() {
  const employees = [
    {
      id: 1,
      name: 'Jojo',
      email: 'jojo@congizant.com',
      mobile: '98238971234',
    },
    {
      id: 2,
      name: 'Sam',
      email: 'sam@congizant.com',
      mobile: '9981184126',
    },
    {
      id: 3,
      name: 'Elisa',
      email: 'elisa@cognizant.com',
      mobile: '9989389735',
    },
  ];

  return (
    <div style={{ display: 'flex', gap: '20px' }}>
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
