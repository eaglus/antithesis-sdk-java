{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  nativeBuildInputs = [
      pkgs.gradle
      pkgs.groovy
      pkgs.jdk8
      pkgs.swig
      pkgs.patchelf
  ];
}
