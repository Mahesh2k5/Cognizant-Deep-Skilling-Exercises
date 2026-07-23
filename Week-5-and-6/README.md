# Weeks 5 & 6: React Exercises

For the final two weeks of the Java FSE track, there were 19 different hands-on documents for React.

### Why one application?
Creating 19 separate React projects would have meant downloading 19 separate instances of `node_modules`. This would take up massive amounts of disk space, build very slowly, and make the project clumsy.

### What's inside?
To solve this, I created a single, unified Vite+React application called `react-exercises`. Inside the `src/components/` folder, you will find individual React components (`Exercise1_ScoreCalculator.jsx`, `Exercise2_StudentList.jsx`, etc.) that prove understanding of all the core concepts taught across those 19 documents.
These concepts include:
*   State management (`useState`)
*   Props handling
*   Event Handling
*   Rendering lists using `.map()` and keys

### How to run:
1. Open your terminal in this `react-exercises` folder.
2. Run `npm install` to download dependencies.
3. Run `npm run dev` to start the development server and view the exercises in your browser!
