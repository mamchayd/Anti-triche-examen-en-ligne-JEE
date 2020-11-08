
var startTime =new Date().getTime();    
   function pollFunc(timeout, interval) {
    interval = interval || 10000;
    (function p() {
	     console.log("----check cheat--");

	     var webSocket;
	     webSocket= new WebSocket('ws://localhost:8080/PFE/websocket');
	     setTimeout(() => {
	    	 webSocket.send('close_session');
	    }, 300);
	     webSocket.onerror = function(event) {
	        onError(event)
	      };

	      webSocket.onopen = function(event) {
	        onOpen(event)
	      };

	      webSocket.onmessage = function(event) {
	        onMessage(event)
	      };

	      function onMessage(event) {
	        if(event.data=="false")
	        {
	        	window.location = "Erreur.jsp";
	        }
	      }

	      function onOpen(event) {
	          console.log("open");

	      }

	      function onError(event) {
	        alert(event.data);
	      }
		 setTimeout(p, interval);
        /*if (((new Date).getTime() - startTime ) <= timeout  )  {
		console.log("d0");
            setTimeout(p, interval);
        }else
		{
		console.log("dddddddddd");
		}*/
    })();
}

pollFunc(6000, 10000);
