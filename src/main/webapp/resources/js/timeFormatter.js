function formatTime() {
    const els = document.getElementsByClassName('format-time');

    for (let i = 0; i < els.length; i++) {
        const el = els.item(i);
        const timestamp = parseInt(el.innerHTML);
        if (!isNaN(timestamp) && el.innerHTML.match('^[0-9]+$')) {
            el.innerHTML = new Date(timestamp).toLocaleString();
        }
    }
}

setInterval(formatTime, 10);