function PreloaderMaterialize(loaderId) {
    var cm = new ClassManagment();
    var el = document.getElementById(loaderId);

    this.start = function(){
        cm.addClass(el, "active");
    };

    this.end = function() {
        cm.removeClass(el, "active");
    }
}

function ClassManagment() {
    this.hasClass = function hasClass(el, className) {
        if (el.classList)
            return el.classList.contains(className);
        return !!el.className.match(new RegExp('(\\s|^)' + className + '(\\s|$)'));
    };

    this.addClass = function addClass(el, className) {
        if (el.classList)
            el.classList.add(className)
        else if (!hasClass(el, className))
            el.className += " " + className;
    };

    this.removeClass = function removeClass(el, className) {
        if (el.classList)
            el.classList.remove(className)
        else if (hasClass(el, className)) {
            var reg = new RegExp('(\\s|^)' + className + '(\\s|$)');
            el.className = el.className.replace(reg, ' ');
        }
    };
}

