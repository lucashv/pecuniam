import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  user : User = {
    id: 1,
    loginName: 'teste',
    password: 'testepassword'
  };  

  constructor() { }

  ngOnInit() {
  }

}
