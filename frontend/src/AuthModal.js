import React, { useState } from 'react';

export default function AuthModal({ mode, onSubmit, onClose, showToast }) {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const isRegister = mode === 'register';

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const userData = isRegister ? { name, email, password } : { email, password };
            await onSubmit(userData);
            // On success, the App component will show the toast
        } catch (err) {
            // NEW: Use the backend error message if available, otherwise a default
            const errorMessage = err.response?.data?.message || (err.response?.status === 403 ? "Invalid email or password." : `An error occurred during ${mode}.`);
            showToast(errorMessage, 'error');
        }
    };

    return (
        <div className="modal-backdrop">
            <div className="modal-content">
                <button className="close-btn" onClick={onClose}>×</button>
                <h2>{isRegister ? 'Create Account' : 'Login'}</h2>
                <form onSubmit={handleSubmit}>
                    {isRegister && (
                        <div className="field">
                            <label>Name</label>
                            <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
                        </div>
                    )}
                    <div className="field">
                        <label>Email</label>
                        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
                    </div>
                    <div className="field">
                        <label>Password</label>
                        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                    </div>
                    <button type="submit" className="btn primary submit-btn">{isRegister ? 'Sign Up' : 'Login'}</button>
                </form>
            </div>
        </div>
    );
}