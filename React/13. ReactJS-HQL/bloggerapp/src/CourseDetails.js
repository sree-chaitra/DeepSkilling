import React from 'react';

const CourseDetails = (props) => {
  const isVisible = props.show;

  if (!isVisible) return null;

  return (
    <div style={{ marginRight: '20px' }}>
      <h2>Course Details</h2>
      <h3>Angular</h3>
      <p>4/5/2021</p>
      <h3>React</h3>
      <p>6/3/2021</p>
    </div>
  );
};

export default CourseDetails;
