// https://jsfiddle.net/pvk6p/7620/


function Stopwatch(idElement) {
    var item = document.getElementById(idElement),
        seconds = 0, minutes = 0, hours = 0,
        t;
   
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

        var timing = (hours ? (hours > 9 ? hours : "0" + hours) : "00") + ":" + (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00") + ":" + (seconds > 9 ? seconds : "0" + seconds);

        item.textContent = timing;

        timer();
    }
    function timer() {
        t = setTimeout(add, 1000);
    }
    timer();


    /* Start button */
    this.start = function start() {
        timer();
    }

    /* Stop button */
    this.stop = function stop() {
        clearTimeout(t);
    }

    /* Clear button */
    this.clear = function clear() {
        item.textContent = "00:00:00";
        seconds = 0; minutes = 0; hours = 0;
    }
    
}

var sw = Stopwatch("totalQuiz_Resumo");
var sw2 = Stopwatch("mediaTempo_Resumo");
 
 function timeToMs(time) {
    var timeParts = time.split(":");
    var ms = (+timeParts[0] * (60000 * 60)) + (+timeParts[1] * 60000) + (+timeParts[2] * 1000);
    return ms
}

function msToTime(s) {

  // Pad to 2 or 3 digits, default is 2
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
