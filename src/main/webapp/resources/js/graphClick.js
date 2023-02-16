function addPoint(e) {
    const sliderWidget = ice.ace.instance('forms:r');

    if (sliderWidget.getValue() % 4 !== 0) return;

    const r = sliderWidget.getValue() / 4 + 2;

    let x = (e.offsetX / (300 / 2) - 1) * r * 1.5;
    x = Math.round(x * 100) / 100;
    let y = (e.offsetY / (300 / 2) - 1) * r * -1.5;
    y = Math.round(y * 100) / 100;

    document.getElementById("graph-form:hidden-x").value = x;
    document.getElementById("graph-form:hidden-y").value = y;
    document.getElementById("graph-form:hidden-r").value = r;
    document.getElementById("graph-form:hidden-submit").click();
}

// In case of canvas rerender, event listener will be added
// If multiple identical EventListeners are registered on the same
// EventTarget with the same parameters, the duplicate instances are discarded.
setInterval(() => {
    const canvas = document.getElementById("graph-canvas");
    canvas.addEventListener('click', addPoint);
}, 10);