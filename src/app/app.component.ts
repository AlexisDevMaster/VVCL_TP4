import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {CalculateService} from './shared/services/calculate.service';
import {NumberResult} from './shared/class/number-result';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'VVCLFront';

  _result: number;
  checkoutForm;

  constructor(
    private calculateService: CalculateService,
    private formBuilder: FormBuilder,
  ) {
    this.checkoutForm = this.formBuilder.group({
      num: 0
    });
    this._result = 0;
  }

  ngOnInit(): void {
    this.calculateService.getCurrentValue().subscribe((n: NumberResult) => {
      console.log(n.result);
      this._result = n.result;
    });
  }

  onSubmit(data): void {
    // Process checkout data here
    this.calculateService.add(data).subscribe((n: NumberResult) => {
      this._result = n.result;
    });
    this.checkoutForm.reset();

    console.warn('Your order has been submitted', data);
  }

  getCurrent(): void{
    this.calculateService.getCurrentValue().subscribe((n: NumberResult) => {
      this._result = n.result;
    });
  }
}
