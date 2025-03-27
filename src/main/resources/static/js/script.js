document.addEventListener('DOMContentLoaded', function() {
    const sections = document.querySelectorAll('section');
    const navLinks = document.querySelectorAll('nav ul li a');
    const menuToggle = document.querySelector('.menu-toggle');
    const nav = document.querySelector('nav');
    const closeMenuBtn = document.querySelector('.close-menu-btn');
    const navShowLinks = document.querySelectorAll('nav.show a'); // Select links when menu is open

    // Function to set the active link based on scroll position
    function setActiveLink() {
    sections.forEach((section, index) => {
        const sectionTop = section.offsetTop;
        const sectionHeight = section.clientHeight;

        if (window.scrollY >= sectionTop - sectionHeight / 3 && window.scrollY < sectionTop + sectionHeight) {
            navLinks.forEach(link => link.classList.remove('active'));
            navLinks[index].classList.add('active');
            
        }
    });
	}

    // Attach the setActiveLink function to the scroll event
    window.addEventListener('scroll', setActiveLink);
    setActiveLink(); // Initial call to set the active link on page load

    // Toggle navigation menu
    menuToggle.addEventListener('click', function() {
        nav.classList.toggle('show');
        menuToggle.setAttribute('aria-expanded', nav.classList.contains('show'));
    });

    // Close navigation menu
    closeMenuBtn.addEventListener('click', function() {
        nav.classList.remove('show');
        menuToggle.setAttribute('aria-expanded', false);
    });

    // Close navigation and scroll on link click (small screens)
    navShowLinks.forEach(function(link) {
        link.addEventListener('click', function(e) {
            if (window.innerWidth <= 992) {
                nav.classList.remove('show');
                menuToggle.setAttribute('aria-expanded', false);

                const targetId = link.getAttribute('href').substring(1); // Remove '#'
                if (targetId) {
                    const targetElement = document.getElementById(targetId);
                    if (targetElement) {
                        targetElement.scrollIntoView({ behavior: 'smooth' });
                    }
                }
            }
        });
    });

    // JavaScript to trigger the fade-in animation
    window.addEventListener('load', () => {
        const servicesSection = document.querySelector('.services-section');
        servicesSection.classList.add('visible');
    });
});