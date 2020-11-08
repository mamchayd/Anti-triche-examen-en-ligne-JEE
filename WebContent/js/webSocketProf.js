/*
	 var webSocket;
function closeSession()
{
	webSocket= new WebSocket('ws://localhost:8080/PFE/websocket');
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
	    console.log(event.data);
	  }

	  function onOpen(event) {
	      console.log("open");

	  }

	  function onError(event) {
	    alert(event.data);
	  }
 setTimeout(() => {
	 webSocket.send('close_session');
}, 500);
}
*/