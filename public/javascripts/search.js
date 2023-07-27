function fetchStockDetails(symbol) {
  console.log('Sending request for symbol:', symbol);
  console.log("BLAHHHH");
  // Perform AJAX GET request to fetch stock details for the selected symbol
  fetch(`/stockDetails/${symbol}`) // Note the use of backticks (`) for string interpolation
    .then(response => response.json())
    .then(data => {
      console.log('Received response:', data);
      // Check if data contains stock details (StockDetails object)
      if (data.symbol && data.last_refreshed && data.open && data.high && data.low && data.close && data.volume) {
        console.log("Start")
        // Display the stock details in the .stock-details container
        const stockDetailsContainer = document.querySelector('.stock-details');
        stockDetailsContainer.innerHTML = `
          <h2>Stock Details for ${data.symbol}</h2>
          <p>Date: ${data.last_refreshed}</p>
          <p>Open: ${data.open}</p>
          <p>High: ${data.high}</p>
          <p>Low: ${data.low}</p>
          <p>Close: ${data.close}</p>
          <p>Volume: ${data.volume}</p>
        `;
      } else {
        console.error('Error fetching stock details: Invalid response format');
      }
    })
    .catch(error => {
      console.error('Error fetching stock details:', error);
    });
}


console.log('Hello');
// Handle the click on the stock list items
const stockItems = document.querySelectorAll('.stock-item');
console.log('Hello');
stockItems.forEach(item => {
  item.addEventListener('click', () => {
    const symbol = item.getAttribute('data-symbol');
    console.log('Clicked on:', symbol);
    fetchStockDetails(symbol);
  });
});
