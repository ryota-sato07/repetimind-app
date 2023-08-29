import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  templateUrl: './delete-output.component.html',
  styleUrls: ['./delete-output.component.scss']
})
export class DeleteOutputComponent implements OnInit {

  constructor(
    private dialogRef: MatDialogRef<DeleteOutputComponent>,
  ) { }

  ngOnInit() {
  }

  // -- [ Methods ] ------------------------------------------------------------
  /**
   * ダイアログを閉じる
   */
  onClose(): void {
    this.dialogRef.close();
  }

}
