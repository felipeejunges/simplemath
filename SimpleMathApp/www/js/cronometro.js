function Stopwatch(idElement) {
    var item = document.getElementById(idElement),
        seconds = 0, minutes = 0, hours = 0,
        t;
    var timing;
    function add() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
            if (minutes >= 60) {
                minutes = 0;
                hours++;
            }
        }

        timing = (hours ? (hours > 9 ? hours : "0" + hours) : "00") + ":" + (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00") + ":" + (seconds > 9 ? seconds : "0" + seconds);

        item.textContent = timing;

        timer();
    }
    function timer() {
        t = setTimeout(add, 1000);
    }

    // Public Functions

    this.start = function() {
        timer();
    }

    this.stop = function() {
        clearTimeout(t);
    }

    this.clear = function() {
        item.textContent = "00:00:00";
        seconds = 0; minutes = 0; hours = 0;
    }

    this.retorno = function() {
        return timing;
    }
    
}

/*
* [ UTILS ]
*/
 function timeToMs(time) { // Convert time function in milliseconds. Expect: HH:mm:ss
    var timeParts = time.split(":");
    var ms = (+timeParts[0] * (60000 * 60)) + (+timeParts[1] * 60000) + (+timeParts[2] * 1000);
    return ms
}

function msToTime(s) { // Convert milliseconds function in time. Return: HH:mm:ss
  function pad(n, z) {
    z = z || 2;
    return ('00' + n).slice(-z);
  }

  var ms = s % 1000;
  s = (s - ms) / 1000;
  var secs = s % 60;
  s = (s - secs) / 60;
  var mins = s % 60;
  var hrs = (s - mins) / 60;

  return pad(hrs) + ':' + pad(mins) + ':' + pad(secs) + '.' + pad(ms, 3);
}
