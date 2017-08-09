

mui.ready(
    function muiCollapse3 (){
        mui.init();
        var inputTap = false;
        mui('.mui-collapse3').on('tap','.allSelect',function(){
            inputTap=true;
        });
        mui('.mui-collapse3').on('tap','.mui-navigate-right',function(){
            if(inputTap){
                inputTap=false;
                return;
            }
            //记录状态
            var li=this.parentNode;
            var ul=this.parentNode.querySelector('.mui-table-view');
            var _style=ul.style.display;
            //关闭同级菜单
            var parent=this.parentNode.parentNode.children;
            for(var i=0;i<parent.length;i++){
                if(!!parent[i].querySelector('.mui-table-view')){
                    parent[i].querySelector('.mui-table-view').style.display='';
                    removeClass(parent[i], 'mui-active');
                }
            }
            //更改状态
            if(_style=='block'){
                ul.style.display='';
                removeClass(li,'mui-active');
            }else{
                ul.style.display='block';
                addClass(li,'mui-active');
            }
            //关闭下级子菜单
            var children=ul.children;
            for(var i=0;i<children.length;i++){
                var child=children[i].querySelector('.mui-table-view');
                if(!!child){
                    child.style.display='';
                    removeClass(children[i], 'mui-active');
                }
            }
        });
        function hasClass(obj, cls) {  
            return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));  
        }  
        function addClass(obj, cls) {  
            if (!this.hasClass(obj, cls)) obj.className += " " + cls;  
        }  
        function removeClass(obj, cls) {  
            if (hasClass(obj, cls)) {  
                var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');  
                obj.className = obj.className.replace(reg, '');  
            }  
        }
    } 
)

