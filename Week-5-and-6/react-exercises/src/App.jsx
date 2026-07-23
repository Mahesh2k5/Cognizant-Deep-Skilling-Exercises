import React from 'react';
import ScoreCalculator from './components/Exercise1_ScoreCalculator';
import StudentList from './components/Exercise2_StudentList';
import Counter from './components/Exercise3_Counter';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Cognizant React Exercises (Weeks 5 & 6)</h1>
      <hr />
      
      <section style={{ marginBottom: '40px' }}>
        <h2>Exercise 1: Score Calculator</h2>
        <ScoreCalculator initialScore={50} />
      </section>

      <section style={{ marginBottom: '40px' }}>
        <h2>Exercise 2: Student List</h2>
        <StudentList />
      </section>

      <section style={{ marginBottom: '40px' }}>
        <h2>Exercise 3: Interactive Counter</h2>
        <Counter />
      </section>
    </div>
  );
}

export default App;