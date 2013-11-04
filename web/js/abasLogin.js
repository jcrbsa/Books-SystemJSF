function stAba(menu,formulario)
	{
		this.menu = menu;

                this.formulario = formulario;
	}
        
          var arAbas = new Array();
	arAbas[0] = new stAba('td_login', 'form_login');
	arAbas[1] = new stAba('td_cadastro', 'form_cadastro');


function AlternarAbas(menu,formulario)
        {	
            

          
		for (var i=0;i<arAbas.length;i++)
		{
			m = document.getElementById(arAbas[i].menu);
			m.className = 'menu';
                        form = document.getElementById(arAbas[i].formulario);
                        form.style.display = 'none';
    
                        
                }
               
		m = document.getElementById(menu);
		m.className = 'menu-sel';
		//c = document.getElementById(conteudo);
                form = document.getElementById(formulario);
                form.style.display='';
                  if(formulario == "form_login"){
                formulario.style.backgroundColor ='yellow';
                  }else if (formulario == "form_cadastro"){
                c.style.backgroundColor ='yellow';
                  }
	}
