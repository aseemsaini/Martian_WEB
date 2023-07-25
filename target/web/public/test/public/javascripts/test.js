
const inputField = document.getElementById("test-input");
const outputArea = document.getElementById("test-area");

const route = document.getElementById("ws-route").value;
const socket = new WebSocket(route.replace("http", "ws"));

inputField.onkeydown = (event) => {
  if(event.key === 'Enter') {
    socket.send(inputField.value);
    inputField.value = '';
  }
}

socket.onopen = (event) => socket.send("New user connected.");

socket.onmessage = (event) => {
  outputArea.value += '\n' + event.data;
}