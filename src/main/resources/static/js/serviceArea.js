var mape = L.map('mape').setView([47.40, -122.25], 9);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(mape);

var counties = {
    king: {
        cities: [
            { name: "Seattle", lat: 47.6062, lng: -122.3321 },
            { name: "Bellevue", lat: 47.6101, lng: -122.2015 },
            { name: "Renton", lat: 47.4851, lng: -122.1957 },
            { name: "Kent", lat: 47.3809, lng: -122.2349 },
            { name: "Auburn", lat: 47.3079, lng: -122.2183 },
            { name: "Federal Way", lat: 47.3129, lng: -122.3138 },
            { name: "Redmond", lat: 47.6740, lng: -122.1215 },
            { name: "Kirkland", lat: 47.6800, lng: -122.2051 },
            { name: "Sammamish", lat: 47.6171, lng: -122.0366 },
            { name: "Issaquah", lat: 47.5307, lng: -122.0308 },
            { name: "Shoreline", lat: 47.7546, lng: -122.3411 },
            { name: "Burien", lat: 47.4662, lng: -122.3400 },
            { name: "Mercer Island", lat: 47.5759, lng: -122.2215 },
            { name: "Duvall", lat: 47.7335, lng: -121.9868 },
            { name: "Snoqualmie", lat: 47.5309, lng: -121.8316 },
            { name: "North Bend", lat: 47.4951, lng: -121.7876 },
            { name: "Algona", lat: 47.2885, lng: -122.2339 },
            { name: "Pacific", lat: 47.2888, lng: -122.2389 },
            { name: "Covington", lat: 47.3501, lng: -122.1121 },
            { name: "Maple Valley", lat: 47.3787, lng: -122.0342 },
            { name: "Carnation", lat: 47.6393, lng: -121.9168 },
            { name: "Enumclaw", lat: 47.2023, lng: -121.9806 }
        ],
        bounds: [[47.77, -122.51], [47.19, -121.78]]
    },
    snohomish: {
        cities: [
            { name: "Everett", lat: 47.9789, lng: -122.2021 },
            { name: "Lynnwood", lat: 47.8284, lng: -122.3135 },
            { name: "Marysville", lat: 48.0515, lng: -122.1772 },
            { name: "Arlington", lat: 48.1610, lng: -122.1334 },
            { name: "Snohomish", lat: 47.9157, lng: -122.0912 },
            { name: "Lake Stevens", lat: 48.0034, lng: -122.0621 },
            { name: "Mukilteo", lat: 47.9137, lng: -122.3020 },
            { name: "Edmonds", lat: 47.8101, lng: -122.3792 },
            { name: "Mill Creek", lat: 47.8762, lng: -122.2081 },
            { name: "Bothell", lat: 47.7607, lng: -122.2057 },
            { name: "Granite Falls", lat: 48.0968, lng: -121.9665 },
            { name: "Stanwood", lat: 48.2434, lng: -122.3423 },
            { name: "Darrington", lat: 48.2618, lng: -121.5976 },
            { name: "Gold Bar", lat: 47.8309, lng: -121.6660 },
            { name: "Index", lat: 47.8201, lng: -121.5645 },
            { name: "Monroe", lat: 47.8540, lng: -121.9845 },
            { name: "Woodway", lat: 47.7840, lng: -122.3785 },
            { name: "Mountlake Terrace", lat: 47.7779, lng: -122.3090 },
            { name: "Sultan", lat: 47.8790, lng: -121.8213 },
            { name: "Tulalip", lat: 48.0968, lng: -122.3164 },
            // Add more Snohomish County cities
        ],
        bounds: [[48.31, -122.52], [47.78, -121.57]]
    },
    pierce: {
        cities: [
            { name: "Tacoma", lat: 47.2529, lng: -122.4443 },
            { name: "Puyallup", lat: 47.1862, lng: -122.3014 },
            { name: "Lakewood", lat: 47.1998, lng: -122.5332 },
            { name: "Bonney Lake", lat: 47.1954, lng: -122.1642 },
            { name: "Sumner", lat: 47.1979, lng: -122.2309 },
            { name: "Gig Harbor", lat: 47.3371, lng: -122.5831 },
            { name: "University Place", lat: 47.2604, lng: -122.5278 },
            { name: "Fife", lat: 47.2415, lng: -122.3559 },
            { name: "Milton", lat: 47.2604, lng: -122.3181 },
            { name: "Ruston", lat: 47.2882, lng: -122.4831 },
            { name: "Orting", lat: 47.1354, lng: -122.2031 },
            // Add more Pierce County cities
        ],
        bounds: [[47.41, -122.62], [46.85, -121.84]]
    }
};

var countyButtons = document.querySelectorAll('.county-button');
var cityList = document.getElementById('city-list');

function displayCounty(countyName) {
    var county = counties[countyName];

    mape.fitBounds(county.bounds);

    cityList.innerHTML = '';

    county.cities.forEach(function(city) {
        var cityItem = document.createElement('div');
        cityItem.textContent = city.name;
        cityList.appendChild(cityItem);

        L.marker([city.lat, city.lng]).addTo(mape)
            .bindPopup(city.name);
    });
}

displayCounty('king');

countyButtons.forEach(function(button) {
    button.addEventListener('click', function() {
        var countyName = button.dataset.county;
        displayCounty(countyName);
    });
});