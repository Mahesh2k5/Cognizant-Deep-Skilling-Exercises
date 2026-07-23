import React from 'react';

function StudentList() {
    const students = [
        { id: 1, name: 'John Doe', grade: 'A' },
        { id: 2, name: 'Jane Smith', grade: 'B' },
        { id: 3, name: 'Sam Johnson', grade: 'C' }
    ];

    return (
        <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '5px' }}>
            <h3>Enrolled Students</h3>
            <ul>
                {students.map(student => (
                    <li key={student.id}>
                        {student.name} - Grade: {student.grade}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default StudentList;