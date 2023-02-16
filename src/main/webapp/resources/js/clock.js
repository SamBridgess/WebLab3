const clock = document.getElementById('clock');

function renderClock() {
    clock.innerHTML = new Date().toLocaleString();
}

renderClock();
setInterval(renderClock, 7000);