import { CadastroService } from './cadastro.service';
import { Component, OnInit } from '@angular/core';
import { Cidades } from './cadastro.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  constructor(private cadastroService: CadastroService,
              private formBuilder: FormBuilder,
              private router: ActivatedRoute) { }

  cadastroForm: FormGroup;

  ngOnInit() {
    this.cadastroForm = this.formBuilder.group({
      nome: this.formBuilder.control('', [Validators.required])
    });
    let id: number = this.router.snapshot.params['id'];
    if (id) {
      this.cadastroService.findById(id).subscribe(res => {
        this.cadastroForm.setValue({
          nome: res.nome
        });
      });
    }
  }

  /**
   * salvarCidades
   */
  public salvarCidades(cidades: Cidades) {
    let id:number = this.router.snapshot.params['id'];
    
    if (!id){ 
      this.cadastroService.salvarCidade(cidades).subscribe(res => {
      });
    } else {
      cidades.id = id;
      this.cadastroService.editarCidade(cidades).subscribe(res => {

      })
    }
  }

}
