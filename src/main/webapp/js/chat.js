/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function ChatWidget(pusher){
    
    var self = this;
    
    this.pusher = pusher;
    
    this.channelName = "chat";
    
    this.chatContainer = $(".chat-widget");
    
    this.messageContainer = $(".chat-messages");
    
    this.chatName = $(".chat-name");
    
    this.chatEntry = $(".chat-entry");
    
    this.channel = this.pusher.subscribe(this.channelName);
    
    this._latestMessages(); 
    
    this.channel.bind("new-message", function(data){
       self._displayMensagens(data);
    });
    
    this.chatEntry.keydown(function(e){
        if(e.keyCode === 13){
            e.preventDefault();
            
            self._sendMensagens({
               name: self.chatName.val(),
               message: self.chatEntry.val()
            });
            
            self.chatEntry.val("");
        }
    });
    
    
}


ChatWidget.prototype._latestMessages = function(){
    var self = this;
   
    $.ajax({
        url : "latest_messages",
        dataType: "json",
        type: "get",
        success : function (data){
            $.each(data, function(i, message){
                self._displayMensagens(message);
            });
        }
    });
};

ChatWidget.prototype._displayMensagens = function(message){
    
    var m = '<li class="left clearfix"><span class="chat-img pull-left"><img src="http://sistema-empresarial.herokuapp.com/js/user.png"/></span><div class="chat-body clear-fix"><div class="header"><strong class="primary-font">'+ message.name +'</strong><small class="pull-right text-muted"><span class="glyphicon glyphicon-time"></span>' + message.created_at + '</small></div><p>'+ message.messages +'</p></div></li>';
    this.messageContainer.prepend(m);
    
};

ChatWidget.prototype._sendMensagens = function(message){
    
    $.ajax({
        url: "create",
        type: 'post',
        data: {
            message: message.message,
            name: message.name
        },
        success: function (data) {
           // console.log(data);
            
        }
    });
    
};





