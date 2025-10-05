import React from 'react';
import ReactDOM from 'react-dom/client';

// This is the most important line for styling. It imports all the CSS rules.
import './index.css'; 

// This imports your main application component.
import App from './App'; 

// This finds the 'root' div in your public/index.html file.
const root = ReactDOM.createRoot(document.getElementById('root'));

// This tells React to render your entire application inside that 'root' div.
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);