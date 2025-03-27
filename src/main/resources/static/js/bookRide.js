let map;
let loading = false;

function initMap() {
    const mapContainer = document.getElementById('map');
    if (!mapContainer) {
        console.error("Map container not found.");
        return;
    }

    map = L.map('map').setView([47.6062, -122.3321], 8);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    L.marker([47.5301, -122.2053]).addTo(map).bindPopup("King County");
    L.marker([48.0628, -122.0435]).addTo(map).bindPopup("Snohomish County");
    L.marker([47.1643, -122.1895]).addTo(map).bindPopup("Pierce County");
}

function setLoading(isLoading) {
    loading = isLoading;
    document.getElementById("loading").innerHTML = isLoading ? "Loading..." : "";
}

document.addEventListener('DOMContentLoaded', function() {
    // Initialize Map
    initMap();

    // Form Submission Handler (including "I am not a robot" check)
    document.getElementById('rideForm').addEventListener('submit', function(event) {
        if (!document.getElementById('robotCheck').checked) {
            event.preventDefault(); // Prevent form submission
            document.getElementById('robotCheckMessage').style.display = 'block';
            document.getElementById('robotCheck').focus();
            return; // Exit here, preventing further execution
        }

        if (!validateForm()) { //Added a ! to prevent form submission if validateForm fails.
            event.preventDefault();
            return;
        }
        // If robot check and validateForm pass, allow normal submission
    });

    // Date/Time Validation
    const dateInput = document.getElementById("date");
    const timeInput = document.getElementById("time");
    function setMinDate() {
        const today = new Date();
        const dd = String(today.getDate()).padStart(2, '0');
        const mm = String(today.getMonth() + 1).padStart(2, '0');
        const yy = today.getFullYear();
        dateInput.setAttribute("min", `${yy}-${mm}-${dd}`);
    }
    function validateTime() {
        const selectedDate = new Date(dateInput.value);
        const currentTime = new Date();
        const oneHourFromNow = new Date(currentTime.getTime() + 60 * 60 * 1000);
        if (dateInput.value === currentTime.toISOString().split('T')[0] && timeInput.value) {
            const selectedTime = new Date(`${dateInput.value}T${timeInput.value}`);
            if (selectedTime < oneHourFromNow) {
                timeInput.setCustomValidity("Please select a time at least one hour from now.");
            } else {
                timeInput.setCustomValidity("");
            }
        } else {
            timeInput.setCustomValidity("");
        }
    }
    dateInput.addEventListener('change', validateTime);
    timeInput.addEventListener('change', validateTime);
    setMinDate();

    // Round Trip Toggle
    const returnFields = document.getElementById('returnFields');
    function toggleReturnFields() {
        const roundTripYes = document.getElementById('roundTripYes');
        returnFields.style.display = roundTripYes.checked ? 'block' : 'none';
    }
    const roundTripYes = document.getElementById('roundTripYes');
    const roundTripNo = document.getElementById('roundTripNo');
    roundTripYes.addEventListener('change', toggleReturnFields);
    roundTripNo.addEventListener('change', toggleReturnFields);
    toggleReturnFields();

    // Scroll to Book Section (if hash is present)
    if (window.location.hash === '#book') {
        const bookingSection = document.getElementById('book');
        if (bookingSection) {
            bookingSection.scrollIntoView({ behavior: 'smooth' });
        }
    }
});

function validateForm() {
    const pickupDate = document.getElementById('date').value;
    const pickupTime = document.getElementById('time').value;
    const passengerPhone = document.getElementById('phone').value;
    const pickupAddress = document.getElementById('pickupStreet').value;
    const dropoffAddress = document.getElementById('dropoffStreet').value;

    if (!pickupDate || !pickupTime || !passengerPhone || !pickupAddress || !dropoffAddress) {
        alert('Please fill in all required fields.');
        return false;
    }

    const phoneRegex = /^\d{10}$/;
    if (!phoneRegex.test(passengerPhone)) {
        alert('Please enter a valid 10-digit phone number.');
        return false;
    }

    const now = new Date();
    const selectedDateTime = new Date(`${pickupDate}T${pickupTime}`);

    if (selectedDateTime <= now) {
        alert('Please select a future date and time.');
        return false;
    }

    return true;
}