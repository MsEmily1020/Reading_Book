interface ButtonInterface4 {
  readonly _type: string;
  width?: number;
  height?: number;
  onInit?(): void;
  onClick(): void;
}

interface ToggleButtonInterface extends ButtonInterface4 {
  toggle(): void;
  onToggled?(): void;
}

interface ImageButtonInterface extends ButtonInterface4, ToggleButtonInterface {
  readonly _url: string;
  getUrl(): string;
  setUrl?(url: string): void;
}

let imageButton = <ImageButtonInterface>{};
