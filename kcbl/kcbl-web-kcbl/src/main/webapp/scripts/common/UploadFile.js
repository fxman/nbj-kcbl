
// common variables
var iBytesUploaded = 0;
var iBytesTotal = 0;
var iPreviousBytesLoaded = 0;
var iMaxFilesize = 2097152; // 2MB
var oTimer = 0;
var sResultFileSize = '';

function secondsToTime(secs) { // we will use this function to convert seconds in normal time format
    var hr = Math.floor(secs / 3600);
    var min = Math.floor((secs - (hr * 3600))/60);
    var sec = Math.floor(secs - (hr * 3600) -  (min * 60));

    if (hr < 10) {hr = "0" + hr; }
    if (min < 10) {min = "0" + min;}
    if (sec < 10) {sec = "0" + sec;}
    if (hr) {hr = "00";}
    return hr + ':' + min + ':' + sec;
};

function bytesToSize(bytes) {
    var sizes = ['Bytes', 'KB', 'MB'];
    if (bytes == 0) return 'n/a';
    var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
    return (bytes / Math.pow(1024, i)).toFixed(1) + ' ' + sizes[i];
};

function alertTimeout(alertText)
{
	setTimeout(function(){
		alert(alertText); 
		}, 100);
	}

function fileSelected() {
    var oFile = document.getElementById('image_file').files[0];
    var rFilter = /^(image\/bmp|image\/gif|image\/jpeg|image\/png|image\/tiff)$/i;
    if (oFile.size > iMaxFilesize) {
    	alert("文件太大");
        return;
    }
    var oReader = new FileReader();
        oReader.onload = function(e){
        	try
        	  {
                document.getElementById('showFileDiv').innerHTML=document.getElementById('showFileDiv').innerHTML+'<img src="'+e.target.result+'"  onclick="showMyImg()" />';
        	  }
        	catch(err)
        	  {
        	  }
        oImage.onload = function () { 
            sResultFileSize = bytesToSize(oFile.size);
        };
    };

   oReader.readAsDataURL(oFile);
    startUploading();
}

function startUploading() {
    iPreviousBytesLoaded = 0;
    var vFD = new FormData(document.getElementById('upload_form')); 
    var oXHR = new XMLHttpRequest();        
    oXHR.upload.addEventListener('progress', uploadProgress, false);
    oXHR.addEventListener('load', uploadFinish, false);
    oXHR.addEventListener('error', uploadError, false);
    oXHR.addEventListener('abort', uploadAbort, false);
    oXHR.open('POST', '/upLoedServlet');
    oXHR.send(vFD);
    oTimer = setInterval(doInnerUpdates, 300);
}

function doInnerUpdates() { // we will use this function to display upload speed
    var iCB = iBytesUploaded;
    var iDiff = iCB - iPreviousBytesLoaded;
    if (iDiff == 0)
        return;

    iPreviousBytesLoaded = iCB;
    iDiff = iDiff * 2;
    var iBytesRem = iBytesTotal - iPreviousBytesLoaded;
    var secondsRemaining = iBytesRem / iDiff;

    var iSpeed = iDiff.toString() + 'B/s';
    if (iDiff > 1024 * 1024) {
        iSpeed = (Math.round(iDiff * 100/(1024*1024))/100).toString() + 'MB/s';
    } else if (iDiff > 1024) {
        iSpeed =  (Math.round(iDiff * 100/1024)/100).toString() + 'KB/s';
    }
}

function uploadProgress(e) { 
    if (e.lengthComputable) {
        iBytesUploaded = e.loaded;
        iBytesTotal = e.total;
        var iPercentComplete = Math.round(e.loaded * 100 / e.total);
        var iBytesTransfered = bytesToSize(iBytesUploaded);
        if (iPercentComplete == 100) {
        }
    } else {
    }
}

function uploadFinish(e) { // upload successfully finished
	alertTimeout("上传完成");
	if(e.target.responseText!=""){
	 document.getElementById('inputFileID').value=document.getElementById('inputFileID').value+e.target.responseText+";"
	 }
    clearInterval(oTimer);
}

function uploadError(e) { // upload error
	alert("Err:"+e.target.responseText);
    clearInterval(oTimer);
}  

function uploadAbort(e) { // upload abort
	alert("Abort");
    clearInterval(oTimer);
}