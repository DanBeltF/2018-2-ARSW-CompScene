var respuestasIndividual;
var respuestaGrupal;


var getPDF = (function pdf() {



    
    
    
    
    function pd(){
        var img= new Image();
        
        img.addEventListener('load', function() {
            alert("hola");
            var doc = new jsPDF();
            doc.addImage(img, 'png', 10, 50);
        });             
        img.src="images/RESULTADOS.png";
        
        
        
        var doc = new jsPDF('landscape');
        doc.text(20, 20, 'Hola, estos son tus resultados');
        doc.addImage(img, 'png', 10, 50);
        
        doc.text(30, 30, 'FELICIDADES');

        doc.save('Test.pdf');
    }
    return {
        pd:pd

    };
})();
