import { Component } from '@angular/core';
import {Cell, Column, Row, SelectColumn, SelectOption} from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.scss'
})
export class AppComponent {

  columns: Column[] = [
    {
      id: '1',
      type: "text",
      name: "description",
    },
    {
      id: '2',
      type: "select",
      name: "type",
      options: [{id: "1", label: "backend", color: "rgba(255,65,116,0.6)"}, {id: "2", label: "frontend", color: "rgba(48,137,255,0.6)"}]
    },
    {
      id: '3',
      type: "date",
      name: "due",
    }
  ]

  rows: Row[] = [{id: '1'}, {id: '2'}];

  table: {[rowID: string]: {[columnID: string]: Cell | undefined}} = {
    '1': {
      '1': {
        rowID: '1', columnID: '1',
        id: '1',
        type: 'text',
        content: 'this fucking project'
      },
      '2': {
        rowID: '1', columnID: '2',
        id: '2',
        type: 'select',
        selected: ['1', '2']
      }
    },
    '2': {
      '1': {
        rowID: '2', columnID: '1',
        id: '3',
        type: 'text',
        content: 'anything else'
      },
      '3': {
        rowID: '2', columnID: '3',
        id: '4',
        type: 'date',
        date: (new Date()).getDate(),
      }
    }
  }

  dropCol(event: any){
    console.log(event)
    this.columns.splice(event.currentIndex, 0, this.columns.splice(event.previousIndex, 1)[0])
  }

  getSelectedValue(columnID: string, selectedID: string): SelectOption | undefined {
    return (this.columns.find((column) => column.id === columnID) as SelectColumn)
      .options.find((option) => option.id === selectedID);
  }

}

