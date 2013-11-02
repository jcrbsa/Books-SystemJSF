function stAba(menu,conteudo,formulario)
	{
		this.menu = menu;
		this.conteudo = conteudo;
                this.formulario = formulario;
	}
        
          var arAbas = new Array();
	arAbas[0] = new stAba('td_login','func1', 'form_login');
	arAbas[1] = new stAba('td_cadastro','func2', 'form_cadastro');


function AlternarAbas(menu,conteudo,formulario)
        {	
            

          
		for (var i=0;i<arAbas.length;i++)
		{
			m = document.getElementById(arAbas[i].menu);
			m.className = 'menu';
			c = document.getElementById(arAbas[i].conteudo);
                        form = document.getElementById(arAbas[i].formulario);
                        form.style.display = 'none';
    
			c.style.display = 'none';
                        
                }
               
		m = document.getElementById(menu);
		m.className = 'menu-sel';
		c = document.getElementById(conteudo);
                form = document.getElementById(formulario);
		c.style.display = '';
                form.style.display='';
                  if(conteudo == "func1" && formulario == "form_login"){
                c.style.backgroundColor ='yellow';
                  }else if (conteudo == "func2" && formulario == "form_cadastro"){
                c.style.backgroundColor ='yellow';
                  }
	}
