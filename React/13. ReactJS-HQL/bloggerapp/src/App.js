// src/App.js
import React from 'react';
import './App.css';
import CourseDetails from './CourseDetails';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';

function App() {
  const showAll = true; // You can toggle this to false to see conditional rendering effects

  return (
    <div style={{ display: 'flex', justifyContent: 'space-around', padding: '40px' }}>
      <CourseDetails show={showAll} />
      <div style={{ borderLeft: '4px solid green', paddingLeft: '20px' }}>
        <BookDetails show={showAll} />
      </div>
      <div style={{ borderLeft: '4px solid green', paddingLeft: '20px' }}>
        <BlogDetails show={showAll} />
      </div>
    </div>
  );
}

export default App;
