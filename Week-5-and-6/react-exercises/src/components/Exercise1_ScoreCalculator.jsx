import React, { useState } from 'react';

function ScoreCalculator({ initialScore = 0 }) {
    const [score, setScore] = useState(initialScore);

    return (
        <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '5px' }}>
            <h3>Current Score: {score}</h3>
            <button onClick={() => setScore(score + 10)}>Increase by 10</button>
            <button onClick={() => setScore(score - 10)} style={{ marginLeft: '10px' }}>Decrease by 10</button>
            <button onClick={() => setScore(initialScore)} style={{ marginLeft: '10px' }}>Reset</button>
        </div>
    );
}

export default ScoreCalculator;