document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('contactFormElement');

    if (form) {
        form.addEventListener('submit', (event) => {
            let isValid = true;

            // Reset error messages
            document.querySelectorAll('.error-message').forEach(el => el.textContent = '');

            // Name validation
            if (form.formName.value.trim() === '') {
                document.getElementById('nameError').textContent = 'Please enter your name.';
                isValid = false;
            }

            // Email validation   
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(form.formEmail.value)) {
                document.getElementById('emailError').textContent = 'Please enter a valid email address.';
                isValid = false;
            }

            // Message validation
            if (form.formMessage.value.trim() === '') {
                document.getElementById('messageError').textContent = 'Please enter your message.';
                isValid = false;
            }

            // Phone Validation
            const phoneRegex = /^[+]?[(]?\d{3}[)]?[-\s\.]?\d{3}[-\s\.]?\d{4,6}$/im;
            if (form.formPhone.value.trim() !== '' && !phoneRegex.test(form.formPhone.value)) {
                document.getElementById('phoneError').textContent = 'Please enter a valid phone number.';
                isValid = false;
            }

            if (!isValid) {
                event.preventDefault(); // Prevent form submission if invalid
            }
            // No else statement needed, server side will handle success.
        });
    } else {
        console.error("Form element with ID 'contactFormElement' not found.");
    }

});