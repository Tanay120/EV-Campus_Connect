import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
});

// This interceptor automatically adds the login token to every request
api.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem('authToken');
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    (error) => Promise.reject(error)
);

export const registerUser = (userData) => api.post('/auth/register', userData);
export const loginUser = (credentials) => api.post('/auth/login', credentials);
export const getVehicles = () => api.get('/vehicles');

// --- ADDED API CALLS ---
export const createBooking = (vehicleId) => api.post('/bookings', { vehicleId });
export const getMyBookings = () => api.get('/bookings/my-bookings');
// Add this with your other export functions
export const deleteBooking = (bookingId) => api.delete(`/bookings/${bookingId}`);

export default api;