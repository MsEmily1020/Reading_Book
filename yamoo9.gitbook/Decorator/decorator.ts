/*
{
  "compilerOptions": {
  ...  
  "experimentalDecorators": true,
  ...
  }
}
*/

function Component(target: Function) {
  console.log(target);
  console.log(target.prototype);

  return function (target: Function) {};
}

// 데코레이터를 사용한 클래스 TabsComponent 정의
@Component
class TabsComponent {}

const tabs = new TabsComponent();
