
// <!DOCTYPE html>
// <html>
// <body>
// <h1 ><time id="h1">00:00:00</time></h1>
// <h1 ><time id="h2">00:00:00</time></h1>
// <button id="start">start</button>
// <button id="stop">stop</button>
// <button id="clear">clear</button>

// <script>
// // https://jsfiddle.net/pvk6p/7620/


// function Stopwatch(idElement) {
//     var item = document.getElementById(idElement),
//         seconds = 0, minutes = 0, hours = 0,
//         t;

//     function add() {
//         seconds++;
//         if (seconds >= 60) {
//             seconds = 0;
//             minutes++;
//             if (minutes >= 60) {
//                 minutes = 0;
//                 hours++;
//             }
//         }

//         var timing = (hours ? (hours > 9 ? hours : "0" + hours) : "00") + ":" + (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00") + ":" + (seconds > 9 ? seconds : "0" + seconds);

//         item.textContent = timing;

//         timer();
//     }
//     function timer() {
//         t = setTimeout(add, 1000);
//     }
//     timer();


//     /* Start button */
//     this.start = function start() {
//         timer();
//     }

//     /* Stop button */
//     this.stop = function stop() {
//         clearTimeout(t);
//     }

//     /* Clear button */
//     this.clear = function clear() {
//         item.textContent = "00:00:00";
//         seconds = 0; minutes = 0; hours = 0;
//     }
// }

// var sw = new Stopwatch("h1");
//  var sw2 = new Stopwatch("h2");

//  start = document.getElementById('start');
//  stop = document.getElementById('stop');
//  clear = document.getElementById('clear');
 
//  start.onclick = sw.start();
//  stop.onclick = sw.stop();
//  clear.onclick = sw.clear();
// </script>

// </body>
// </html>



function timeToMs(time) {
	var timeParts = time.split(":");
	var ms = (+timeParts[0] * (60000 * 60)) + (+timeParts[1] * 60000) + (+timeParts[2] * 1000);
    document.getElementById("demo").innerHTML = ms
    document.getElementById("demo2").innerHTML = msToTime(ms)
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


class Stopwatch {
    constructor(idElement) {
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
        this.t = null;
        this.item = document.getElementById(idElement);
    }

    add() {
        this.seconds++;
        if (this.seconds >= 60) {
            this.seconds = 0;
           this.minutes++;
            if (this.minutes >= 60) {
                this.minutes = 0;
                this.hours++;
            }
        }

        var timing = (this.hours ? (this.hours > 9 ? this.hours : "0" + this.hours) : "00") + ":" + (this.minutes ? (this.minutes > 9 ? this.minutes : "0" + this.minutes) : "00") + ":" + (this.seconds > 9 ? this.seconds : "0" + this.seconds);

        this.item.text = timing;

        this.timer();
    }
    timer() {
        this.t = setTimeout(this.add, 1000);
    }

    stop() {
        clearTimeout(this.t);
    }

    start() {
        this.timer();
    }

    clear() {
        this.item.textContent = "00:00:00";
        this.seconds = 0; this.minutes = 0; this.hours = 0;
        return
    }

}
sw = new Stopwatch("h1");


var h1 = document.getElementById('h1')[0],
    start = document.getElementById('start'),
    stop = document.getElementById('stop'),
    clear = document.getElementById('clear'),
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
   
    h1.textContent = timing;

    timer();
}
function timer() {
    t = setTimeout(add, 1000);
}
timer();


/* Start button */
start.onclick = timer;

/* Stop button */
stop.onclick = function() {
    clearTimeout(t);
}

/* Clear button */
clear.onclick = function() {
    h1.textContent = "00:00:00";
    seconds = 0; minutes = 0; hours = 0;
}

