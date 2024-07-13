// Function to fetch data from the server
async function fetchData() {
    try {
        const response = await fetch('https://bilyari.onrender.com/pumps'); // Replace with your server URL
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();

        console.log(data);
        displayData(data); // Call function to display data on the webpage
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

// Function to display data on the webpage
function displayData(data) {
    const dataContainer = document.getElementById('dataContainer');
    dataContainer.innerHTML = ''; // Clear previous content
    data.forEach(pump => {
        const pumpElement = document.createElement('div');
        pumpElement.textContent = `ID: ${pump.id}, Name: ${pump.name}, Value: ${pump.value}`;
        dataContainer.appendChild(pumpElement);
    });
}

// Initial fetch when the page loads
fetchData();

// Fetch data every 3 seconds
setInterval(fetchData, 3000);
