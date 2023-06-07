#!/bin/bash


read -p "Introduce un número: " numero


if [ $numero -eq 0 ]; then
    echo "El número es cero."
fi


if [ $numero -lt 0 ]; then
    echo "El número es negativo."
else
    echo "El número es positivo."
fi

if [ $((numero % 2)) -eq 0 ]; then
    echo "El número es par."
else
    echo "El número es impar."
fi


function divide() {
    resultado=$(echo "scale=2; $1 / 2" | bc)
    echo "El resultado de dividir $1 por dos es: $resultado"
}

divide $numero

for ((i=0; i<numero; i++)); do
    echo -n "*"
done

echo ""
