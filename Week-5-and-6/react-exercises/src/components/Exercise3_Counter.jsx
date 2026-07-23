import React, { useState } from 'react';

function Counter() {
    const [count, setCount] = useState(0);

    return (
        <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '5px' }}>
            <h3>Counter value: {count}</h3>
            <button onClick={() => setCount(c => c + 1)}>Increment</button>
            {count > 0 && <p style={{ color: 'green' }}>The counter is positive!</p>}
        </div>
    );
}

export default Counter;